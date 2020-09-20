# 链表

## 普通链表+删除指定key：有insertFirst、deleteFirst、deleteKey方法。
* 注意删除key的方法里，删除第一个（这种情况和deleteFirst实际上一样）和删除中间的略有不同（后者要多处理一个节点）
* 注意并没有insertLast、deleteLast方法，这是因为普通链表本身没有last指针，节点也没有previous，这两个方法都需要一个低效率的循环才能完成。

## 双端链表（有first、last指针）：有insertFirst、deleteFirst、insertLast方法。
* 相较情况1，插入方法必须单独用一个分支考虑当前链表为空的时候的情况，因为插入一个之后，first和last都指向同一个节点。
* 相较情况1，删除方法必须单独用一个分支考虑当前链表只有一个节点的情况，因为当前状态first、last指向同一个节点，删除之后两个都变为null对象。
* insertLast比insertFirst多处理一个节点。
* 注意只有insertLast，但没有deleteLast方法，这是因为双端链表本身没有previous，如果需要deleteLast，则需要一个低效率的循环才能记录previous节点。

## 双向链表（有first、last指针，每个节点还有previous指针）：有insertFirst、deleteFirst、insertLast、deleteLast方法。
* 两个插入方法都必须单独用一个分支考虑当前链表为空的情况，因为插入一个之后，first和last都指向同一个节点。
* 两个删除方法都必须单独用一个分支考虑当前链表只有一个节点的情况，因为删除之前first和last都指向同一个节点，删除之后两个都变为null对象。
* insertLast并不比insertFirst多处理一个节点，因为这次都要处理previous（只是两种情况的previous处理方式不同）。
* deleteLast并不比deleteFirst多处理一个节点因为这次都要处理previous（只是两种情况的previous处理方式不同）。
* 非空的插入、非剩一的删除相较情况2都必须添加队previous的处理
* 既有insertLast，又增加了deleteLast方法，这次无需低效循环
## ADT（普通链表实现队列和栈）：有InsertFirst、removeFirst、removeLast（这个是队列的必要方法，所以即使必须用低效循环也必须要实现出来）方法。

## 有序链表（普通链表）：有特殊的insert方法、removeFirst方法
* insert是有序插入，注意插入位置first, middle, last的区别，都需要保留一个previous指针以便修改previous.next

