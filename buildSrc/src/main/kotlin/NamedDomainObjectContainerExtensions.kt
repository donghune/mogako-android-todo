import org.gradle.api.NamedDomainObjectContainer

inline val <T> NamedDomainObjectContainer<T>.release: T get() = test { }
fun <T> NamedDomainObjectContainer<T>.test(block: T.() -> Unit): T =
    getByName("release") { block() }

inline val <T> NamedDomainObjectContainer<T>.dev: T get() = dev { }
fun <T> NamedDomainObjectContainer<T>.dev(block: T.() -> Unit): T =
    getByName(Flavor.RELEASE) { block() }
