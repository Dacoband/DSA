public void main String[] args {
   int[] arr = new int[100];
   random rand = new random();
   for (int i = 0; i < arr.Length; i++){
         arr[i] = rand.Next(0, 101);
   }
   Console.WriteLine("Original array: ");
   foreach(var num in arr){
         Console.Write(i + " ");
   }
    Console.WriteLine();
    
    int ThirdLargest = FindThirdLargest(arr);
    Console.WriteLine("Third largest element: " + ThirdLargest);

    static int FindThirdLargest(int[] arr){
        int first, second, third;
        first = second = third = int.MinValue;
        for (int i = 0; i < arr.Length; i++){
            if (arr[i] > first){
                third = second;
                second = first;
                first = arr[i];
            }
            else if (arr[i] > second){
                third = second;
                second = arr[i];
            }
            else if (arr[i] > third){
                third = arr[i];
            }
        }
        return third;
    }
}

