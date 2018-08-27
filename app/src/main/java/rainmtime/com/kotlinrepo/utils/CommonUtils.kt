package rainmtime.com.kotlinrepo.utils

/**
 * Created by chunyu on 2018/8/27 上午11:02.
 * Email: 746431278@qq.com
 */
object CommonUtils {

    fun <T, V : MutableCollection<T>> removeNullItems(collection: V?): V? {
        if (collection == null) {
            return null
        }

        val it: MutableIterator<T> = collection.iterator()
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove()
            }
        }
        return collection
    }


    fun isCollectionEmpty(collection: Collection<*>?): Boolean {
        return collection?.isEmpty() ?: false
    }

}