import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class driver_3085 {

	public static void main(String[] args) throws IOException ,InterruptedException, ClassNotFoundException {
		
		   Configuration conf = new Configuration();
	        Job job = Job.getInstance(conf, "Word Count");

	        job.setJarByClass(driver_3085.class);
	        job.setMapperClass(mapper_3085.class);
	        job.setReducerClass(reducer_3085.class);

	        job.setMapOutputKeyClass(Text.class);      
	        job.setMapOutputValueClass(IntWritable.class);

	        FileInputFormat.addInputPath(job, new Path(args[0]));
	        FileOutputFormat.setOutputPath(job, new Path(args[1]));
	        
	        job.waitForCompletion(true);
	}

}