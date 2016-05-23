package foo;

import spock.lang.Specification
import spock.lang.Unroll

public class FooSpec extends Specification
{
	@Unroll
	def 'toStringSpecial works as expected for #input#inputClass.'() {
		expect:
		Foo.toStringSpecial(input) == expectedResult
		
		where:
		input | expectedResult
		1     | 'special: 1'
		'foo' | 'special: private-static-special: foo'

		inputClass = input == null ? '' : ' (' + input.getClass() + ')'
	}
}