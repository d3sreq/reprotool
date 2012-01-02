package reprotool.ling.tools;

import java.io.ByteArrayOutputStream;
import java.io.PipedInputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.Platform;

/**
 * @author ofiala
 *
 */
public class TaggerThread extends Thread {	

	boolean runs = false;
	// tool IO
	PipedInputStream pins;
	ByteArrayOutputStream baos;
	ByteArrayOutputStream err;
	
	TaggerThread(String name) {
		super(name);
	}

	TaggerThread(PipedInputStream pins, ByteArrayOutputStream baos, ByteArrayOutputStream err) {
		super("tagger");
		this.pins = pins;
		this.baos = baos;		
		this.err = err;
		System.setIn(this.pins);
	}

	// run one at time
	public synchronized void run() {
		String path = "";
		
		// locating external model
		try{
			path = Platform.getPreferencesService().getString("reprotool.ide", "mxpostModel", "/tagger.project", null);
		} catch (NullPointerException e){
			String rootPath;
			try {
				rootPath = new java.io.File(Tagger.class.getResource("/").toURI()).getParentFile().getParent();
			} catch (URISyntaxException e1) {
				rootPath = new java.io.File(Tagger.class.getResource("/").getPath()).getParentFile().getParent();
			}
			path = rootPath + "/reprotool.tools.mxpost/data/tagger.project";
			//path = rootPath + "/../tools/MXPost_tagger/tagger.project";
		}
		
		// set error stream
		PrintStream ps = new PrintStream(err);
		System.setErr(ps);
		
		// run external tool MXPOST
		tagger.TestTagger.main(new String[] {path});
		// thread is still running until stdIn is closed
	}
}
