/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pasient;

/*

Studentnr: s188097
Navn: Ole Bøe Andreassen


Klasse: Dataingeniør

*/

import java.io.*;
import java.util.*;

public class PasientRegister implements Serializable
{
  private Pasient pasient;
  private List<Pasient> reg = new ArrayList<>();
  
  public PasientRegister()
  {
  }

 public Pasient finn(String n, int fd )//finner pasient
  {      
          if(!reg.isEmpty())
          {
            for( Pasient p : reg)
            {
                 if( p.getNavn().equals(n) && p.getFDato() == fd)
                    return p;
            }
          }
          return null;
  }

  public boolean finnes ( String n, int fd ) // finnes bilen?
  {
      return finn(n,fd) != null;
  }


  public boolean tom () //er lista tom?
  {
      return reg.isEmpty();
  }

 public boolean fjern( String n, int fd )
  {
          if(!reg.isEmpty())
          {
            for( Pasient p : reg)
            {
                 if( p.getNavn() == n && p.getFDato() == fd)
                    reg.remove(p);
                 return true;
            }
          }
          return false;
  }

  public void settInnNy( Pasient ny )
  {
    reg.add(ny);
  }

  public void sorter()
  {
	 Collections.sort(reg,new ComparatorImpl());
  }

  public String getText()
  {
    String tekst = "                PASIENTER:\n";

    for (Pasient x : reg)
      tekst += x.toString() + "\n";
    if (tekst.equals("") == false)
	  return tekst;
    else
      return "Listen er tom";
  }

    private static class ComparatorImpl implements Comparator<Pasient> {

        public ComparatorImpl() {
        }

        @Override
        public int compare(Pasient o1, Pasient o2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


}