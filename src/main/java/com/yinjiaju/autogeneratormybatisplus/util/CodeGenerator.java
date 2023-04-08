package com.yinjiaju.autogeneratormybatisplus.util;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * @author Yin
 */
public class CodeGenerator {

    public static void main(String[] args) {
        generateCode();
    }

    public static void  generateCode() {
        // 1、创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 2、全局配置
        GlobalConfig globalConfig = AutoGenerateUtil.buildGlobalConfig();
        autoGenerator.setGlobalConfig(globalConfig);

        // 3、数据源配置
        DataSourceConfig dataSourceConfig = AutoGenerateUtil.buildDataSourceConfig();
        autoGenerator.setDataSource(dataSourceConfig);

        // 4、包配置
        PackageConfig packageConfig = AutoGenerateUtil.buildPackageConfig();
        autoGenerator.setPackageInfo(packageConfig);

        // 5、策略配置
        StrategyConfig strategyConfig = AutoGenerateUtil.buildStrategyConfig();
        autoGenerator.setStrategy(strategyConfig);

        // 6、执行
        autoGenerator.execute();
    }
}
