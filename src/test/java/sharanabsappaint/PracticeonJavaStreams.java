package sharanabsappaint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class PracticeonJavaStreams {
	// @Test
	public void regular()

	{

		ArrayList<String> names = new ArrayList<String>();
		names.add("Raju");
		names.add("Somu");
		names.add("Ramu");
		names.add("Rajshekhar");
		names.add("Sharanabasappa");
		int count = 0;
		for (int i = 0; i < names.size(); i++)

		{
			String actual = names.get(i);
			if (actual.startsWith("R"))

			{

				count++;
			}
			System.out.println(count);
		}
	}

	// @Test
	public void streamfilter()

	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Raju");
		names.add("Somu");
		names.add("Ramu");
		names.add("Rajshekhar");
		names.add("Sharanabasappa");

		Long e = names.stream().filter(s -> s.startsWith("R")).count();
		Long f = names.stream().filter(s -> s.endsWith("u")).count();
		System.out.println(e);
		System.out.println(f);
	}

	// @Test
	public void Streamfilter1()

	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Raju");
		names.add("Somu");
		names.add("Ramu");
		names.add("Rajshekhar");
		names.add("Sharanabasappa");

		Long d = Stream.of("Raju", "Somu", "Ramu", "Rajshekhar", "Sharanabsappa").filter(s ->

		{
			s.startsWith("R");
			return true;
		}).count();
		System.out.println(d);

		names.stream().filter(s -> s.length() > 5).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 5).limit(1).forEach(s -> System.out.println(s));
	}

	// @Test
	public void streamMap()

	{

		Stream.of("Raju", "Somu", "Ramu", "Rajshekhar", "Sharanabsappa").filter(s -> s.endsWith("u"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		Stream.of("Raju", "Somu", "Ramu", "Rajshekhar", "Sharanabsappa").map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

	// @Test
	public void StreamSort()

	{

		List<String> names = Arrays.asList("Raju", "Somu", "Ramu", "Rajshekhar", "Sharanabsappa");

		names.stream().filter(s -> s.startsWith("S")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

	@Test
	public void MergingTwoList()

	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Arun");
		names.add("Ram");
		names.add("Anil");

		List<String> names1 = Arrays.asList("Raju", "Somu", "Ramu", "Rajshekhar", "Sharanabsappa");
		names1.stream().filter(s -> s.startsWith("R")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		Stream<String> newspa = Streams.concat(names.stream(), names1.stream());
		newspa.sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

	}
}
