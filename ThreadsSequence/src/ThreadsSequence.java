
public class ThreadsSequence {

	public static class ThreadOne extends Thread {
		@Override
		public void run() {
			System.out.print("A ");
			System.out.print("B ");
		}
	}
	
	public static class ThreadTwo extends Thread {
		@Override
		public void run() {
			System.out.print("1 ");
			System.out.print("2 ");
		}
	}

	public static void main(String[] args) {
		new ThreadOne().start();
		new ThreadTwo().start();
	}

}
