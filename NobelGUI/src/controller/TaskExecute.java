package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Nobel;

/**
 *
 * @author nyirweb
 */
public class TaskExecute 
{
    private static List<Nobel> allNobels = new ArrayList<>();
    private EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("NobelGUIPU");
    private NobelJpaController nobelJPA = new NobelJpaController(this.entityMF);

    public TaskExecute() 
    {
        this.allNobels = nobelJPA.findNobelEntities();
    }
    
    public String taskThree()
    {        
        for (Nobel n : allNobels) {
            String fullName = n.getKeresztnev()+" "+n.getVezeteknev();
            if(fullName.equals("Arthur B. McDonald"))
            {
                return n.getTipus();
            }
        }
        return "";
    }
    
    public String taskFour()
    {        
        String in2017 = "";
        for (Nobel n : allNobels) {
            String fullName = n.getKeresztnev()+" "+n.getVezeteknev();
            if(n.getEv().equals("2017") && n.getTipus().equals("irodalmi"))
            {
                return fullName;
            }
        }
        return in2017;
    }

    public String[] taskFive()
    {
        List<String> companiesWithNobel = new ArrayList<>();
        
        for (Nobel n : allNobels) 
        {
            int y = Integer.valueOf(n.getEv());
            if(n.getVezeteknev().equals("") && y >= 1990)
            {
                companiesWithNobel.add(y+": "+n.getKeresztnev());
            }
        }

        int length = companiesWithNobel.size();
        String[] result = new String[length];
        
        for (int i = 0; i < companiesWithNobel.size(); i++) 
        {
            result[i] = companiesWithNobel.get(i);
        }
        
        return result;
    }
    
    public String[] taskSix()
    {        
        String[] result = new String[0];
        List<String> curies = new ArrayList<>();
        
        for (Nobel n : allNobels) {
            String fullName = n.getKeresztnev()+" "+n.getVezeteknev();
            String year = n.getEv();
            String type = n.getTipus();
            
            if(fullName.contains("Curie"))
            {
                String line = year+": "+fullName +"("+type+")";
                curies.add(line);
            }
        }
        
        result = new String[curies.size()];
        for (int i = 0; i < curies.size(); i++) 
        {
            result[i] = curies.get(i);
        }
        
        
        return result;
    }

    public String[] taskSeven()
    {
        List<String> nobelTypes = new ArrayList<>();
        List<String> uniqueNobel = new ArrayList<>();
        String[] result = new String[0];
        
        for (Nobel n : allNobels) 
        {
            nobelTypes.add(n.getTipus());
        }
        
        Set<String> uniqueTypes = new HashSet<String>(nobelTypes);
        for (String s : uniqueTypes) 
        {
            String line = s+" : "+Collections.frequency(nobelTypes, s);
            uniqueNobel.add(line);
        }
        
        int length = uniqueNobel.size();
        result = new String[length];
        
        for (int i = 0; i < uniqueNobel.size(); i++) 
        {
            result[i] = uniqueNobel.get(i);
        }
        
        return result;
    }
    
    public String[] taskEight()
    {
        String[] result = new String[0];
        List<String> medicalNobels = new ArrayList<>();
        
        
        Collections.sort(allNobels,(Comparator.comparing(Nobel::getEv)));
        for (Nobel n : allNobels) 
        {
            int year = Integer.valueOf(n.getEv());
            String fullName = n.getKeresztnev()+" "+n.getVezeteknev();
            
            if(n.getTipus().equals("orvosi"))
            {
                medicalNobels.add(String.valueOf(year)+";"+fullName);
            }
        }
        
        result = new String[medicalNobels.size()];        
        for (int i = 0; i < medicalNobels.size(); i++) 
        {
            result[i] = medicalNobels.get(i);
        }
        
        return result;
    }
    
    public ArrayList<String> writeMedicalNobels()
    {
        ArrayList<String> lines = new ArrayList<>();
        TaskExecute taskExecute = new TaskExecute();
        String[] medicalResult = taskExecute.taskEight();
        
        for (String s : medicalResult) 
        {
            lines.add(s);
        }
        CreateOrvosiFile.createOrvosiFile(lines, "orvosi.txt");
                
        return lines;
    }
}
