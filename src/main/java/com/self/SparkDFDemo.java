package com.self;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class SparkDFDemo {

    SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("DemoX");
    transient SparkSession sc = SparkSession.builder().config(sparkConf).getOrCreate();

    public void start(){

    }
}
