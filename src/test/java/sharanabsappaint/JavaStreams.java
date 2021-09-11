package sharanabsappaint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class JavaStreams {
	// count the number of names start with aplhabet A in list

	 @Test(groups= {"Sap"})
	public void regular()

	{

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Arun");
		names.add("Ram");
		names.add("Anil");

		int count = 0;

		for (int i = 0; i < names.size(); i++)

		{
			String actual = names.get(i);
			if (actual.startsWith("A"))

			{
				count++;
			}

		}
		System.out.println(count);
	}

	 @Test(groups= {"Sap"})
	public void StreamFilter()

	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Arun");
		names.add("Ram");
		names.add("Anil");

		// their is no life for intermidate operatoin if their is no terminal operation
		// terminal op will execute only if inter op(filter) returns true
		// we can create a stream
		// how to use filter in stream api0

		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		boolean flag = names.stream().anyMatch(s -> s.equalsIgnoreCase("Ram"));
		System.out.println(flag);

		Assert.assertTrue(flag);

		long d = Stream.of("Abhishek", "Don", "Arun", "Ram", "Anil").filter(s ->

		{
			s.startsWith("A");
			return true;
		}

		).count();
		System.out.println(d);

	// print aLL THE names of the list length >3

		names.stream().filter(s -> s.length() > 3).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 3).limit(1).forEach(s -> System.out.println(s));

	}

	@Test(enabled=false)
	public void streamMap()

	{
		// print the names which have last letter "a" with upperCase
		Stream.of("Abhishek", "Don", "Aruna", "Rama", "Anil").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// print all the names with uppercase letter
		// Stream.of("Abhishek", "Don", "Aruna", "Rama", "Anil").map(s ->
		// s.toUpperCase()).forEach(s -> System.out.println(s));

		// print the names which have first letter as a with uppercase and sorted

		List<String> names = Arrays.asList("Abhishek", "Don", "Aruna", "Rama", "Anil");

		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

	}

	 @Test(enabled=false)
	public void MergingtwoList()

	{
		ArrayList<String> names = new ArrayList<String>();

		names.add("Men");
		names.add("Don");
		names.add("Women");

		List<String> names1 = Arrays.asList("Abhishek", "Don", "Aruna", "Rama", "Anil");
		names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// mergeing 2 different list

		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		// newStream.sorted().forEach(s->System.out.println(s));

		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Don"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test(groups= {"Sap"})
	public void streamcollect()

	{
		List<String> ls = Stream.of("Abhishek", "Don", "Aruna", "Rama", "Anil").filter(s -> s.startsWith("A"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());

		System.out.println(ls.get(0));

		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);

		// print the unique number from this array
		values.stream().distinct().forEach(s -> System.out.println(s));

		// sort the array
		values.stream().sorted().forEach(s -> System.out.println(s));

		// sort the array with unique style and print the third index

		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(3));

		boolean flag = values.stream().anyMatch(s -> s.equals(3));
		System.out.println(flag);
		Assert.assertTrue(flag);

	}
}
