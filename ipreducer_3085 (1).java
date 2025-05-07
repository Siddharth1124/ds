import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer_3085 extends Reducer<Text, IntWritable, Text, IntWritable> {
    
	private Text maxWord = new Text();
    private int maxCount = 0;

    public void reduce(Text word, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        if (sum > maxCount) {
            maxCount = sum;
            maxWord.set(word);
        }
    }
    protected void cleanup(Context context) throws IOException, InterruptedException {
        context.write(maxWord, new IntWritable(maxCount));
    }
}