Problem Statement : We are given a set P of n points in a two-dimensional plan, and we want to compute the convex hull of P. The convex hull is defined as the smallest convex polygon containing the points. (A way to visualize a convex hull is to imagine nails on all the points of the plane and put an elastic band around the points – the shape of the elastic band is the convex hull.) Describe an O(n log n) time divide and conquer algorithm to find the convex hull of the set P of n points.

Solution: 

Imagine you have a bunch of points, and you want to find the shape that covers all these points without any dent or curve - that's the convex hull. Now, if you already know the convex hulls for the left half of the points and the right half, the problem is how to combine these two shapes into one big shape that covers all points.

Here's how we do it: first, we need to find the convex hull for the left and right halves. To do this, we keep dividing the points into smaller groups until we have very few points, say 5. For these tiny groups, we use a simple method to find their convex hulls.

Once we have the hulls for the small groups, we merge them. Imagine putting the left and right shapes together like two puzzle pieces fitting perfectly. When we combine these smaller shapes, we get the final convex hull that covers all the points. This step-by-step process ensures we find the right shape for our given set of points.

•	In the code, the function ‘generateRandomPoints(n,0,100)’ generates an array of random integers between 0 and 100. We can adjust the range and the number of points generated based on our requirements. Each time we run the program, a different set of random points will be generated, leading to potentially different convex hulls.

•	The different values of n I’ve considered are 15, 111, 730, 1202, 6550, 10000, 49840, 100000.

•	For n value less than '3' it returns the whole input points as output/convex hull.






