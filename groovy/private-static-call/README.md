Related issue: [GROOVY-7844 - Groovy executes private static methods if signature matches best.](https://issues.apache.org/jira/browse/GROOVY-7844)

### TLDR
Calling `Foo.toSpecialString('foo')` is calling the `private static` method directly instead of calling th `public static` method of the same name. 