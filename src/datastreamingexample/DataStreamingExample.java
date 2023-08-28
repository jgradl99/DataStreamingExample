
package datastreamingexample;

import java.util.concurrent.TimeoutException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;



/**
 *
 * @author jgradl99
 */
public class DataStreamingExample {

    /**
     * @param args the command line arguments
     * @throws java.util.concurrent.TimeoutException
     * @throws org.apache.spark.sql.streaming.StreamingQueryException
     */
    public static void main(String[] args) throws TimeoutException, StreamingQueryException {
        SparkSession spark = SparkSession.builder()
                   .appName("example")
                   .master("local")
                   .getOrCreate();
        
        StructType schema = new StructType().add("id", DataTypes.IntegerType)
                                            .add("first_name", DataTypes.StringType)
                                            .add("last_name", DataTypes.StringType);
        
        Dataset<Row> data = spark.readStream()
                    .format("csv")
                    .option("header", "true")
                    .schema(schema)
                    .csv("./data/*.csv");
                data.createOrReplaceTempView("viewData");
                
        Dataset<Row> result = spark.sql("select * from viewData where id < 7");
        System.out.println(result);
        StreamingQuery query = result.writeStream().outputMode(OutputMode.Update())
                .format("console").start();
        query.awaitTermination();
        
    }
    }  
    
