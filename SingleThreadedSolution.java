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