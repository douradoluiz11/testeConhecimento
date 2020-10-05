package br.com.inmetrics.teste.environment;

import java.io.File;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import br.com.inmetrics.teste.exceptions.NoSuchEnvironmentException;


/**
 * Author: Luiz Henrique Dourado
 */
public class EnvironmentResolver {
	 private static Config env;
	    private static Config ssh;
	    private static String envType = "default";
	    private static String envFileName = "env.conf";

	    public static Config getEnv() {
	        if(env==null){
	            env = getSafeFileProp(envFileName);
	            if(System.getProperties().containsKey("env")) {
	                envType = System.getProperty("env");
	            } else if(System.getenv().containsKey("env")){
	                envType = System.getenv("env");
	            }
	            env = env.withFallback(env.getConfig("environments."+envType)).withFallback(env.getConfig("environments.all"));
	        }
	        return env;
	    }

	    public static Config getSsh() {
	        if(ssh == null) {
	            ssh = getSafeFileProp("ssh.conf");
	        }
	        return ssh;
	    }

	    public static Config getConf(String path) {
	        return getSafeFileProp(path);
	    }

	    public static String getNamedConfValue(String name, String path) throws NoSuchEnvironmentException {
	        Config conf = getConf(path);
	        String value = "";
	        if(conf.hasPath(name)){
	            value =  conf.getString(name);
	        } else {
	            throw new NoSuchEnvironmentException(name);
	        }
	        return value;
	    }

	    public static Config getNamedSsh(String name) throws NoSuchEnvironmentException {
	        getSsh();
	        Config value;
	        if(ssh.hasPath("ssh."+name)){
	            value = ssh.getConfig("ssh."+name);
	        } else {
	            throw new NoSuchEnvironmentException(name);
	        }
	        return value;
	    }

	    public static String getNamedEnvValue(String name) throws NoSuchEnvironmentException {
	        getEnv();
	        String value = "";
	        if(env.resolve().hasPath(name)){
	            value = env.resolve().getString(name);
	        } else if(env.getConfig("environments").resolve().hasPath(name)){
	            value = env.getConfig("environments").resolve().getString(name);
	        } else if(env.getConfig("environments.all").resolve().hasPath(name)) {
	            value = env.getConfig("environments.all").resolve().getString(name);
	        }else if(env.getConfig("environments.uat").resolve().hasPath(name)){
	                value = env.getConfig("environments.uat").resolve().getString(name);
	        }else if(env.getConfig("environments.stg").resolve().hasPath(name)){
	            value = env.getConfig("environments.stg").resolve().getString(name);
	        } else {
	            throw new NoSuchEnvironmentException(name);
	        }
	        return value;
	    }

	    private static Config getSafeFileProp(String envFileName) {
	        File configFile = new File(envFileName);
	        Config preferences = null;
	        if (configFile.exists()) {
	            preferences = ConfigFactory.parseFile(configFile);
	            return preferences;
	        } else {
	            preferences = ConfigFactory.load(configFile.getName());
	            return preferences;
	        }
	    }
}