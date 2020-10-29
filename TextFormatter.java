class TextFormatter {
  private int lineLength;

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    
    TextFormatter formatter = new TextFormatter(30);
    formatter.leftFlutterPrint(text);
    System.out.println("");
    formatter.rightFlutterPrint(text);
    System.out.println("");
    formatter.blockSentencePrint(text);
 
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    lineLength = maxLineLength;
  }

  // Formatierte Ausgabe
  public void print(String aText) {
    int lineLength = 30;
    String formattedLine = "";
    int lineStart= 0; 
    int position=0; 
    int lineEnd = lineLength;
  

    while (lineStart < aText.length()){
    position = aText.lastIndexOf(" ", lineEnd);
  
    // letzte Zeile
    if ((aText.length() - lineStart) <= lineLength){
     formattedLine = aText.substring(lineStart, aText.length()); 
     position= aText.length()+1;
    
    } else if (position <= lineEnd && position > lineEnd-2){
      formattedLine = aText.substring(lineStart, position);
    
    } else {
        //bei einem Komma, keinen Bindestrich einfügen
       //Bindestrich einfügen
       formattedLine = aText.substring(lineStart, lineEnd) + "-";
       position = lineEnd; 

    }
    lineStart = position; 
    lineEnd= lineStart + lineLength;
    System.out.println(formattedLine);
  }}


  // rechter Flattersatz Ausgabe
    public void rightFlutterPrint(String aText) {
    int lineLength = 30; 
    String formattedLine = "";
    int lineStart= 0; 
    int position=0; 
    int lineEnd = lineLength;
    String dash = " ";

    while (lineStart < aText.length()){
    position = aText.lastIndexOf(" ", lineEnd);

     // letzte Zeile
    if ((aText.length() - lineStart) <= lineLength){
      for (int freeSpace=0; freeSpace <= aText.length()-position; freeSpace++){  
        dash += " "; 
        }
     formattedLine = dash + aText.substring(lineStart, aText.length()); 
     position= aText.length()+1;
    
    } else if (position == lineEnd){
      formattedLine = " "+ aText.substring(lineStart, position);

    } else if (position == lineEnd-1){
      formattedLine = "  "+ aText.substring(lineStart, position);
    
    } else {
       //Bindestrich einfügen
       formattedLine = aText.substring(lineStart, lineEnd) + "-";
       position = lineEnd; 
    }
      
    lineStart = position;   
    lineEnd= lineStart + lineLength;
    System.out.println(formattedLine);
  }
 }
 


 public void leftFlutterPrint(String aText) {
    int lineLength = 30; 
    String formattedLine = "";
    int lineStart= 0; 
    int position=0; 
    int lineEnd = lineLength;
  

    while (lineStart < aText.length()){
    position = aText.lastIndexOf(" ", lineEnd);
    // letzte Zeile
    if ((aText.length() - lineStart) <= lineLength){
     formattedLine = aText.substring(lineStart, aText.length()); 
     System.out.println(formattedLine);
     break;
     
    } else if (position == lineEnd ){
      formattedLine = aText.substring(lineStart, position);
      position+=2;

    
    }else if (position == lineEnd-1){
     formattedLine = aText.substring(lineStart, position);
     position+=1;
    }

    else{  
      formattedLine = aText.substring(lineStart, lineEnd) + "-";
       position = lineEnd;
       }

    lineStart = position; 
    lineEnd= lineStart + lineLength;
    System.out.println(formattedLine);
  }
  }


 //nicht ganz geschafft
 // block sentence 
  public void blockSentencePrint(String aText) {
    int lineLength = 30; 
    //TextFormatterExpl.lineLength
    String formattedLine = "";
    int lineStart= 0; 
    int position=0; 
    int lineEnd = lineLength;
  

    while (lineStart < aText.length()){
    position = aText.lastIndexOf(" ", lineEnd);
  
    // letzte Zeile
    if ((aText.length() - lineStart) <= lineLength){
     formattedLine = aText.substring(lineStart, aText.length()); 
     position= aText.length()+1;
    
     } else if (position == lineEnd){

      formattedLine = aText.substring(lineStart, position);
      int blockSentence2 = formattedLine.lastIndexOf(" ", lineLength-5);
       formattedLine = formattedLine.substring(0, blockSentence2) + " " + formattedLine.substring(blockSentence2, lineLength);
       position+=2;     



     }else if (position == lineEnd-1){
    
      int blockSentence2 = formattedLine.lastIndexOf(" ", lineLength-5);
      int blockSentence = formattedLine.lastIndexOf(" ", lineLength-15);   
       formattedLine = formattedLine.substring(0, blockSentence) + " " + formattedLine.substring(blockSentence, blockSentence2) + " " + formattedLine.substring(blockSentence2, lineLength);
       position+=1;

    
    } else {
       formattedLine = aText.substring(lineStart, lineEnd) + "-";
       position = lineEnd; 

    }
    lineStart = position; 
    lineEnd= lineStart + lineLength;
    System.out.println(formattedLine);
  }}


}