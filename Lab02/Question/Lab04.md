## Q.1

If the passing object is not an instance of Media => Runtime error

## Q.2

Should implement the Comparable interface in class Media

## Q.3

### Implement compareTo() method be to reflect the ordering that we want

<code>
public int compareTo(Media media) { </br>
&nbsp return Comparator.comparing(Media::getCost) <br/>
&nbsp &nbsp .thenComparing(Media::getTitle) <br/>
&nbsp &nbsp .compare(this, media); <br/>
}
</code>

### Implement compareTo() method be to reflect the ordering that we want in DigitalVideoDisc

<code>
public int compareTo(Media media) { <br/>
&nbsp DigitalVideoDisc dvd =(DigitalVideoDisc) media;<br/>
&nbsp return Comparator.comparing(DigitalVideoDisc::getTitle)<br/>
&nbsp &nbsp .thenComparing(DigitalVideoDisc::getLength) <br/>
&nbsp &nbsp .thenComparing(DigitalVideoDisc::getCost) <br/>
&nbsp &nbsp .compare(this, dvd); <br/>
}
</code>
