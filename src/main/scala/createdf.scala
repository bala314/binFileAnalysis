import org.apache.spark.sql.{Row, SQLContext, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object createdf {

  def main(args:Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Creating dataframe in dif methods")
      .master("local")
      .getOrCreate()
    val rdd = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5))
    rdd.collect.foreach(println)
    // Creating a dataframe using struct type
     val scheema = StructType(
      StructField("Integer as string",StringType,true):: Nil
    )
        val rowrdd = rdd.map(x => Row(x))
    rowrdd.collect().foreach(println)
    // val df = spark.createDataFrame(rowrdd,scheema)


   /* val df1 = spark.read.csv("file:///C://users//b0p03a0//Downloads//factbook.csv")
    df1.show() */

  }
}
