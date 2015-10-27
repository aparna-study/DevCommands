import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.io.InterruptedIOException;


public class StudentAcademicMapper extends Mapper<LongWritable, Text, StudentIDKey, JoinGenericWritable>{

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String[] recordFields = value.toString().split("\\t");
		int stud_id=Integer.parseInt(recordFields[0]);
		String status=recordFields[2];
		String major=recordFields[3];
		float gpa=Float.parseFloat(recordFields[4]);
		
		StudentIDKey studIdKey=new StudentIDKey(stud_id,StudentIDKey.ACADEMIC_RECORD );
		StudentAcademicDetails record= new StudentAcademicDetails(major,status,gpa);
		
		JoinGenericWritable genericRecord= new JoinGenericWritable(record);
		context.write(studIdKey, genericRecord);
		
	}
}
