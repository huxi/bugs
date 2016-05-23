package foo;

import spock.lang.Specification
import spock.lang.Unroll
import java.util.*

public class FooSpec extends Specification
{
	@Unroll
	def 'toStringSpecial works as expected for #input#inputClass.'() {
		expect:
		Foo.toStringSpecial(input) == expectedResult
		
		where:
		input     | expectedResult
		[] as Set | 'Set: []'
		'foo'     | 'String: foo'

		inputClass = input == null ? '' : ' (' + input.getClass() + ')'
	}
	
	def 'toStringSpecial(Set) works as expected for null.'() {
		expect:
		Foo.toStringSpecial((Set)null) == 'Set: null'
	}

	def 'toStringSpecial(String) works as expected for null.'() {
		expect:
		Foo.toStringSpecial((String)null) == 'String: null'
	}

	def 'toStringSpecial(Object) works as expected for null.'() {
		expect:
		Foo.toStringSpecial((Object)null) == 'Object: null'
	}

	def 'toStringSpecial(Set) works as expected for null as Set.'() {
		expect:
		Foo.toStringSpecial(null as Set) == 'Set: null'
	}

	def 'toStringSpecial(String) works as expected for null as String.'() {
		expect:
		Foo.toStringSpecial(null as String) == 'String: null'
	}

	def 'toStringSpecial(Object) works as expected for null as Object.'() {
		expect:
		Foo.toStringSpecial(null as Object) == 'Object: null'
	}

	def 'toStringSpecial(no cast) works as expected for null.'() {
		expect:
		Foo.toStringSpecial(null) == 'Object: null'
	}
}