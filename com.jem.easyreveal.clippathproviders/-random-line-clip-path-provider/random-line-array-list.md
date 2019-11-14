[easyreveal](../../index.md) / [com.jem.easyreveal.clippathproviders](../index.md) / [RandomLineClipPathProvider](index.md) / [randomLineArrayList](./random-line-array-list.md)

# randomLineArrayList

`var randomLineArrayList: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`

[ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html) of random integers in the range 1..100

The idea is to have pseudo random lines, [Arraylist](#) is directly used instead of getting true Random() values,
to prevent any delays during reveal/hide animation &amp; also to enable smooth recovery during animation swapping.

### Exceptions

`IllegalArgumentException` - thrown when arrayList size is not 100 or when values are not in the range 1..100