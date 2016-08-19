package uq.deco2800.ducktales.entities;
import java.util.*;

/** Creates enemies and effects and manages when they are deployed
 * 
 * 
 * @author Wian
 *
 */


public class ThreatManager {
 private ArrayList<Effects> EffectsList = new ArrayList<Effects>();
 private ArrayList<Enemies> EnemiesList = new ArrayList<Enemies>();
 
 //Temp variables
 public Effects tempEffect;
 public Enemies tempEnemy;
 
 public void ThreatsLVL1(){
	 //Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
	 
	 //------Effects---------
	 	//Create Temp variable
	 	tempEffect = new Effects("Earthqauke");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	EffectsList.add(tempEffect);
	 	
	 	//Create Temp variable
	 	tempEffect = new Effects("Poisson Cloud");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	EffectsList.add(tempEffect);
	 	
	 	
	 //-------Enemies--------
	 	//Create Temp variable
	 	tempEnemy = new Enemies("Deathclaw");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	EnemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemies("Cartman");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	EnemiesList.add(tempEnemy);
	 	
	 	
	 
	 
	 
	 
 }
 
 
 
 
 public void ThreatsLVL2(){
	//Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
 }
 
 
 public void ThreatsLVL3(){
	//Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
	 
 }
 public void ThreatsLVL4(){
	//Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
	 
 }
 
 
 
 
}
