package com.baidu.jprotobuf.mojo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.baidu.bjf.remoting.protobuf.utils.compiler.JdkCompiler;

import jodd.io.findfile.ClassScanner;

/**
 * @author xiemalin
 * @since 1.0
 */
public class JprotobufPreCompileMain {

	public static void main(String[] args) {

		if (args == null || args.length == 0 || args.length != 3) {
			throw new RuntimeException(printUsage());
		}
		
		final File outputPath = new File(args[0] + File.separator + "temp");
		try {
			FileUtils.deleteDirectory(outputPath);
		} catch (Exception e) {
		}
		outputPath.mkdirs();
		
		JDKCompilerHelper.setCompiler(new JdkCompiler(Thread.currentThread().getContextClassLoader()));
		
		final String filterClassPackage = args[2];

		ClassScanner scanner = new ClassScanner() {

			@Override
			protected void onEntry(EntryData entryData) throws Exception {
				String name = entryData.getName();
				if (filterClassPackage != null) {
					if (!name.startsWith(filterClassPackage)) {
						return;
					}
				}
				
				Class c = getByClass(name);
				if (c == null) {
					return;
				}

				try {
					List<Field> fields = FieldUtils.findMatchedFields(c, Protobuf.class);
					if (!fields.isEmpty()) {
						ProtobufProxy.create(c, false, outputPath);
					}
				} catch (Throwable e) {
				    throw new Exception(e.getMessage(), e);
				}
			}
		};

		scanner.scanDefaultClasspath();
		
		// copy files
		try {
			FileUtils.copyDirectory(outputPath, new File(args[1]));
		} catch (IOException e) {
		}

	}

	private static String printUsage() {
		return "Usage: " + JprotobufPreCompileMain.class.getName() + " outputFile";
	}

	private static Class getByClass(String name) {
		try {
			return Thread.currentThread().getContextClassLoader().loadClass(name);
		} catch (Throwable e) {
		}
		return null;
	}

}
