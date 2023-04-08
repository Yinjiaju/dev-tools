package com.yinjiaju.autogeneratormybatisplus.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author Yin
 */
public class AutoGenerateUtil {

    /**
     * 构建数据库配置
     * @return
     */
    public static GlobalConfig buildGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        // 此处建议写项目/src/main/java源代码的绝对路径
        gc.setOutputDir("G:\\dev_tools\\AutoGenerator-mybatisPlus" + "/src/main/java");
        // 生成注释时的作者
        gc.setAuthor("yinjiaju");
        //生成后是否打开资源管理器
        gc.setOpen(false);
        //重新生成时文件是否覆盖
        gc.setFileOverride(false);
        //去掉Service接口的首字母I
        gc.setServiceName("%sService");
        //主键策略
        gc.setIdType(IdType.ID_WORKER_STR);
        //定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 如果开启Swagger,要引入相应的包:开启Swagger2模式
        gc.setSwagger2(true);
        return gc;
    }

    /**
     * 配置数据源
     * @return
     */
    public static DataSourceConfig buildDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        //useSSL=false 连接远程必须配置
        dsc.setUrl("jdbc:mysql://192.168.71.10/hurry_job?useSSL=false");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");//数据库名称
        dsc.setPassword("123456");//密码
        dsc.setDbType(DbType.MYSQL);
        return dsc;
    }

    /**
     * 构建包名
     * @return
     */
    public static PackageConfig buildPackageConfig() {
        PackageConfig pc = new PackageConfig();
        // 此处要注意：parent + moduleName 为包的名字，在这个包下，创建对应的controller...
        pc.setParent("com.yinjiaju");
        //模块名
        pc.setModuleName("autoModule");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        return pc;
    }

    /**
     * 构建生成策略
     * @return
     */
    public static StrategyConfig buildStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        // 数据库中表的名字，表示要对哪些表进行自动生成controller service、mapper...
        strategy.setInclude("erp_subject","erp_user");
        // 数据库表映射到实体的命名策略,驼峰命名法
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成实体时去掉表前缀，比如edu_course，如果不加下面这句，生成的实体类名字就是：EduCourse
        //strategy.setTablePrefix("news_","create_","update_","read_","picture_","modification_");
        //生成实体时去掉表前缀
        strategy.setTablePrefix("erp_");

        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);
        //restful api风格控制器
        strategy.setRestControllerStyle(true);
        //url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        return strategy;
    }
}
