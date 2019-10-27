package com.allstargh.ssm.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 逆向生成
 * 
 * @author gzh
 *
 */
public class ReverseGenerator {
	public static void main(String[] args)
			throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		InputStream inputStream = ReverseGenerator.class.getClassLoader().getResource("generator_configur.xml")
				.openStream();

		ConfigurationParser cp = new ConfigurationParser(warnings);

		Configuration config = cp.parseConfiguration(inputStream);

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

		myBatisGenerator.generate(null);

		inputStream.close();

		System.out.println("successful.");
	}

}