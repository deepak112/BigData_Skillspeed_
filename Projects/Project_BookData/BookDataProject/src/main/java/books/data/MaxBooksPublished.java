package books.data;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class MaxBooksPublished {
  
	
		
	public static class MapClass extends Mapper<LongWritable, Text, Text, IntWritable>{
		
		public static final IntWritable one = new IntWritable(1);
   
    public void map(LongWritable key, Text value,Context context) throws IOException, InterruptedException {
      String[] rows = value.toString().split("\";\"");
      String year = rows[3];
      context.write(new Text(year), one);
      }
    
  }

  public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>
  {
	  int max = 0;
	  Text _key = new Text();
    
    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
      
    	int sum = 0;
    	for(@SuppressWarnings("unused") IntWritable val: values){
    		sum++;
    	}
    	if (sum > max)
    	{
    		max = sum;
    		_key.set(key);
    	}
    }
    
    @Override
    protected void cleanup(Context context)
    		throws IOException, InterruptedException {
    	// TODO Auto-generated method stub
    	context.write(_key, new IntWritable(max));
    	super.cleanup(context);
    }
  }
  

  public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
	  
	Configuration conf = new Configuration();
    @SuppressWarnings("deprecation")
	Job job = new Job(conf, "Count");
    //job.setJobName("MarketRatings");
    job.setJarByClass(MaxBooksPublished.class);


    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    job.setMapperClass(MapClass.class);
    job.setReducerClass(Reduce.class);

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);

  }
}