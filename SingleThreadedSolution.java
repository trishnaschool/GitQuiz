import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class SingleThreadedSolution{
final static long num = 1_000_000_000;

	public static void main(String[]args){
		long startTime = System.nanoTime();
		SingleThread();
		long elapsedTime1 = System.nanoTime() - startTime;
		System.out.println("Single thread:" + elapsedTime1);
		MultiThread();
		long elapsedTime2 = System.nanoTime() - startTime - elapsedTime1;
		System.out.println("Multi thread:" + elapsedTime2);

	}

	public static void SingleThread(){
		Runnable Task =(() -> {
		int count = 0;
		for (int i = 0; i < num; i++){
			count++;
		}
	  });
	}

	public static void MultiThread(){
		final int numThreads = 1000;
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		long numsPerThread = num/numThreads;

		for (int i = 0; i < numThreads; i++){
			final long start = (i * numsPerThread) + 1;
			final long end = start + numsPerThread - 1;

			Callable<Long> task = ()-> {
				long count = 0;
				for (long number = start; number <= end; number++){
					count++;
				}

				return count++;
			};
		}
	}


}