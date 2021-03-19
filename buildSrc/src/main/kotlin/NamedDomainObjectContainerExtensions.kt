import org.gradle.api.NamedDomainObjectContainer

inline val <T> NamedDomainObjectContainer<T>.release: T get() = test { }
fun <T> NamedDomainObjectContainer<T>.release(block: T.() -> Unit): T =
    getByName(Flavor.RELEASE) { block() }

inline val <T> NamedDomainObjectContainer<T>.main: T get() = main { }
fun <T> NamedDomainObjectContainer<T>.main(block: T.() -> Unit): T =
    getByName("main") { block() }

inline val <T> NamedDomainObjectContainer<T>.test: T get() = main { }
fun <T> NamedDomainObjectContainer<T>.test(block: T.() -> Unit): T =
    getByName("test") { block() }

inline val <T> NamedDomainObjectContainer<T>.androidTest: T get() = main { }
fun <T> NamedDomainObjectContainer<T>.androidTest(block: T.() -> Unit): T =
    getByName("androidTest") { block() }
