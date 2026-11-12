public class SingleThreadedSolution{

	public static void main(String[]args){
		long startTime = System.nanoTime();
		final long num = 1_000_000_000;
		Thread thread = new Thread (() -> {
			int count = 0;
			for (int i = 0; i < num; i++){
				count++;
			}
		});

		thread.start();

		long elapsedTime = System.nanoTime() - startTime;
		System.out.println(elapsedTime);
	}

}

/*
We created a new branch. Since we didnt merge multithread to main, this branch only shows what's in
the main branch. We created a single thread that counts to one billion, then returned the time. In multithread, we then created a method using
multiple threads, using executorservice and callable. Then, we returned this time. We used nanotime to track it.
*/