import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class mapper_3085 extends Mapper<Object, Text, Text, IntWritable> {
   
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
   
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split("\\s+");
        for (String term : words) {
            word.set(term);
            context.write(word, one);
        }
    }
}