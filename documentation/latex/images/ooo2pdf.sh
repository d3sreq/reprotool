#!/bin/bash

# created by Viliam Simko 2007-01-12
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

	cmdavail pdfcrop || {
		echo "The pdfcrop utility is not installed"
		echo "This should be a small python script"
		echo "On Ubuntu try to install the texlive-extra-utils package"
		exit 1
	}

	cmdavail unoconv || {
		echo "The unoconv utility is not installed"
		echo "Try to install the unoconv package and libre/open office"
		exit 1
	}
}

function write_separator()
{
	# prepares the separator 
	eval `resize`
	echo `seq 1 $COLUMNS | sed 's/^.*//' | tr '\n' '-'`
}

# Convert ODG file to PDF using OpenOffice macro.
# $1 = ODG filename
function convert_odg_to_pdf()
{
	echo -n "  Converting to PDF: $1 ... "
	unoconv -f pdf "$1" 2> /dev/null
	echo "done"
}

# Removes redundant borders from PDF file.
# $1 = PDF filename
function crop_pdf_file()
{
	echo -n "  Processing PDF: $1 ... "
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

ls -1 *.odg | while read ODGNAME
do
	PDFNAME=`echo $ODGNAME | sed 's/\.odg$/.pdf/'` 
	if [ "$ODGNAME" -nt "$PDFNAME" ]
	then
		convert_odg_to_pdf "$ODGNAME"
		crop_pdf_file "$PDFNAME"
		synchronize_mtime "$ODGNAME" "$PDFNAME"
	else
		echo "  No conversion needed for: $ODGNAME."
	fi
done

# ---------------------------- 
write_separator
# ---------------------------- 

