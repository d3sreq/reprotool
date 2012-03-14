#!/bin/bash

# created by Viliam Simko 2007-01-12
# 2012-02-29 : Viliam Simko : added "crop" switch, which implies cropping PDF files without converting from source format
# 2011-12-23 : Viliam Simko : fixed error message if *.svg or *.odg files do not exist
# 2011-12-19 : Viliam Simko : added SVG->PDF using Inkscape
# 2011-05-05 : Viliam Simko : added system_check

cd `dirname "$0"`

CURRENT_DIR=`pwd`
TMPFILE=".pdfcrop"

function cmdavail() {
	type "$1" &> /dev/null
}

function system_check()
{
	cmdavail resize || {
		echo "The resize command is not installed"
		echo "However, this is not mandatory"
		echo "Try to install xterm"
	}


	cmdavail unoconv || {
		echo "The unoconv utility is not installed"
		echo "Try to install the unoconv package and libreoffice/openoffice"
	}

	{ unoconv; } &> /dev/null
	[ "$?" -eq 0 ] || {
		echo "WARNING: LibreOffice/OpenOffice UNO bridge (unoconv) does not work properly!"
	}

	cmdavail inkscape || {
		echo "Inkscape is not installed. It is required for SVG->PDF conversion."
		echo "Try to install inkscape, e.g. sudo apt-get install inkscape"
	}

	cmdavail pdfcrop || {
		echo "The pdfcrop utility is not installed"
		echo "This should be a small python script."
		echo "On Ubuntu try to install the texlive-extra-utils package"
		exit 1
	}
}

function write_separator()
{
	# prepares the separator
	eval `resize`
	echo `seq 1 $COLUMNS | sed 's/^.*//' | tr '\n' '-'`
}

# $1 = ODG NAME, $2 = PDF NAME
function convert_odg_to_pdf()
{
	unoconv -f pdf "$1" 2> /dev/null
	echo "done."

	NEWPDFNAME="${1%.*}.pdf"
	[ "$NEWPDFNAME" != "$2" ] && mv "$NEWPDFNAME" "$2"
	crop_pdf_file "$2"
}

# $1 = SVG NAME, $2 = PDF NAME
function convert_svg_to_pdf()
{
	# unfortunately, SVG filters such as Duotone will resterized
	inkscape --export-dpi=300 --export-pdf="$2" "$1" 2> /dev/null
	echo "done."
}

# Removes redundant borders from PDF file.
# $1 = PDF filename
function crop_pdf_file()
{
	echo -n "  Cropping PDF: $1 ... "
	pdfcrop "$1" "$TMPFILE" > /dev/null
	mv "$TMPFILE" "$1"
	echo "done"
}

# $1 = mtime source
# $2 = mtime desctination
function synchronize_mtime()
{
	touch -r "$1" "$2"
}

# ---------------------------- 
write_separator
# ---------------------------- 
system_check

find . -name '*.odg' -or -name '*.svg' | while read INPUTNAME
do
	BASENAME="${INPUTNAME%.*}"
	SUFFIX="${INPUTNAME##*.}"
	PDFNAME="$BASENAME".pdf

	if [ "$INPUTNAME" -nt "$PDFNAME" -o "$INPUTNAME" -ot "$PDFNAME" ] # modification time differs
	then

		if [ "$1" = "crop" ]
		then

			if [ ! -f "$PDFNAME" ]
			then
				echo "PDF file not found: $PDFNAME"
				continue
			fi

			crop_pdf_file "$PDFNAME"
			# The original file and the created PDF files will have the same modification time
			synchronize_mtime "$INPUTNAME" "$PDFNAME"
			continue
		fi

		# run the conversion
		echo -n "  Converting to PDF: $INPUTNAME ... "
		convert_"$SUFFIX"_to_pdf "$INPUTNAME" "$PDFNAME"
		# The original file and the created PDF files will have the same modification time
		synchronize_mtime "$INPUTNAME" "$PDFNAME"
		continue
	fi

	echo "  No conversion needed for: $INPUTNAME."
done

# ---------------------------- 
write_separator
# ---------------------------- 

