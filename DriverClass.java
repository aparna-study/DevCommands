import java.io.IOException;
import java.io.InterruptedIOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.MultiFileInputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class DriverClass extends Configured implements Tool{
 
	public int run(String[] allArgs) throws IOException,InterruptedException{
		String[] args=new GenericOptionsParser(getConf(),allArgs).getRemainingArgs();
		
	//	JobConf job = new JobConf(new Configuration(), DriverClass.class);
		
		Job job = Job.getInstance(getConf());
		job.setJarByClass(DriverClass.class);
		
//job.setOutputFormatClass(TextOutputFormat.class);
		//job.setInputFormatClass(TextInputFormat.class);
		
		job.setMapOutputKeyClass(StudentIDKey.class);
		job.setMapOutputValueClass(JoinGenericWritable.class);
		
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, StudentAddressMapper.class);
	    MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, StudentAcademicMapper.class);
	                              
	    job.setReducerClass(JoinReducer.class);
	                         
	    job.setSortComparatorClass(JoinSortingComaparator.class);
	    job.setGroupingComparatorClass(JoinGroupingComparator.class);
	                               
	    job.setOutputKeyClass(NullWritable.class);
	    job.setOutputValueClass(Text.class);
	                               
	    FileOutputFormat.setOutputPath(job, new Path(args[2]));
	    
	    boolean status = job.waitForCompletion(true);
	    if (status) {
	        return 0;
	    } else {
	        return 1;
	    }    
		
		
	}
}
