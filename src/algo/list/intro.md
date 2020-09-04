# Linked List (Singly Linked List)
## key concepts
in the order of usefulness.
* **head**
  * is the first entry of the list
  * represents a list. most linked list problem input is the head of a linked list.  
  * can change as the result of some manipulation, eg if asked to reverse a linked list.         
* **current**
  * is the node currently looking at
  * is the most important to know/remember/keep-track-of
* **next**
  * is pointed by current.next
* **previous**
  * is the node before current.
  * is needed to remember if needs to reference when handling current node. 
* **tail**
  * is the last entry of the list. can be the same as the head if list contains one enry
  * harder problems requires tail manipulation. 

## Special List
* circular linked list
  * tail point back to head
 
## Techniques 
There're two kind of techniques to solve linked list problems. 
1. iteration 
2. recursion
Most time iteration is preferred than recursion because it's more efficient in terms of computing resource consumption.


## Sample Problems
## Create a list of a specified size 
* there's no input head
* output is a head 
* likely need some special handling of the first entry (ie remember it as the return head)

## Print a list 
* given a list, output list content. 
* input is a head
* output is a String

## Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
* usually the first linked list problem.
* input is a head
* output is a different head
* because need to reverse, need to remember previous node
* before reverse current (ie current.next = previous), need to remember current.next

## Remove Linked List Elements
https://leetcode.com/problems/remove-linked-list-elements/  
* Remove all elements from a linked list of integers that have value val.
* a variation of reverse linked list 

## Linked List Components 
https://leetcode.com/problems/linked-list-components/submissions/
* another application of tracking prev while using curr to iterate over the list.
* pretty easy don't feel it's a medium 

## Delete Node in a Linked List
https://leetcode.com/problems/delete-node-in-a-linked-list/
* a trick question 

## 1017 Next Greater Node In Linked List
https://leetcode.com/problems/next-greater-node-in-linked-list/
* more an array and stack problem than a list problem 

## 445 Add Two Numbers II
https://leetcode.com/problems/add-two-numbers-ii/
* use recursion to solve linked list problem
* align two lists by the tail 