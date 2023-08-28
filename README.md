# DataStreamingExample

This project is a simple example to show the power of Apache Spark on a small scale using Java.
The goal is to continously run SQL requests on an incoming datastream. In this example, the incoming stream is described with a single csv file consisting of 1000 lines filled with 'id', 'first_name' and 'last_name'. But it does support more and larger files as long as the file follows the set scheme.

# Install

- Download Spark from https://spark.apache.org/downloads.html and add all JAR files to the project
- Include the latest winutils version into your project folder https://github.com/steveloughran/winutils
- Set 'HADOOP_HOME' and 'HADOOP_HOME/bin' as new environment variables and restart your PC

# Example

The data folder includes the incoming datasteam. In this example its described with 'ExampleData.csv'.
After setting the scheme of our stream to fit the needs of the data, we can now finally run SQL requests on the input.
An example could be 'select * from viewData where id < 7'. Running this will give us all names with ids under 7 as seen in the table below.

| id|first_name|last_name|
|---|----------|---------|
|  1|     Lorne|     Faso|
|  2| Katharina|  Damarra|
|  3|      Vita|Pettiford|
|  4|     Moyna|  Goddard|
|  5|     Dotty|Pillsbury|
|  6|       Zia|   Yorick|
