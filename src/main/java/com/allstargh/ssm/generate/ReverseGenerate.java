package com.allstargh.ssm.generate;

import java.io.InputStream;
import java.util.ArrayList;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 逆向生成
 * 
 * @author admin
 *
 */
public class ReverseGenerate {
	public static void main(String[] args) throws Exception {
		ArrayList<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		InputStream is = ReverseGenerate.class.getClassLoader().getResource("generator_configur.xml").openStream();

		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(is);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

		is.close();
		System.out.println("生成代码成功，刷新项目，查看文件");

	}

}