package com.self;

import com.self.model.Droput;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SparkDf implements Serializable{

    SparkConf sparkConf = new SparkConf().setSparkHome("MyAPP").setMaster("local[*]");
    transient SparkSession sparkSession;

    SparkDf(){
        sparkSession = SparkSession.builder().config(sparkConf).getOrCreate();
    }

    public void start(){

        Encoder<Droput> encoders = Encoders.bean(Droput.class);
        Dataset<Droput> df = sparkSession.read().json("/Users/thegod/dropout.json").as(encoders);
        df.createOrReplaceTempView("dropout");


    }

    public static void main(String[] args) {

        SparkDf sparkDf = new SparkDf();
        sparkDf.start();

    }
}
