package com.chenchu.integrations;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkPhoenix {

	public static void main(String[] args) {
		SparkSession ss = SparkSession.builder().appName("phoenix-connector").master("spark://chenchu:7077")
				.config("spark.sql.warehouse.dir", System.getProperty("java.io.tmpdir") + "/spark-wherehouse")
				.getOrCreate();

		Dataset<Row> df = ss.read().format("org.apache.phoenix.spark").option("table", "STUDENT")
				.option("zkUrl", "localhost:2181").load();
		df.show();
	}
}
