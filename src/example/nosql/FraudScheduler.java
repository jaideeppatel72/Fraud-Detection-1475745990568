package example.nosql;



import java.io.FileReader;
import java.util.Date;
import java.util.List;

import example.FraudDAO.NationalInsuranceDaoImpl;
import example.bean.NationalInsuranceBean;
import example.util.DateUtil;
import au.com.bytecode.opencsv.CSVReader;

public class FraudScheduler 
{
	public void execute() 
    {
        try
        {
//	       	  final String csvFilename = ResourceBundleUtil.getConstant("CSV_FILE_PATH", "NATIONAL_INS.CONSTANTS");
	   	      CSVReader csvReader = new CSVReader(new FileReader(""));
	   	      List<String[]> allRows = csvReader.readAll();
	   	      System.out.println(System.getenv());
	   	   NationalInsuranceDaoImpl objNationalInsuranceDaoImpl = new NationalInsuranceDaoImpl();
	   	      for(String[] row : allRows)
	   	      {
	   	        	if((row[0]!=null || !("").equals(row[0])) && (row[5]!=null || !("").equals(row[5])))
	   	        	{
	   	        		NationalInsuranceBean nationalInsuranceBean=objNationalInsuranceDaoImpl.getInsuranceDataFrmId(Long.parseLong(row[0]));
	   	        		if(nationalInsuranceBean!=null && nationalInsuranceBean.getNiNumber()!=null)
	   	        		{
	   	        			Date dod=DateUtil.toDate(row[5]);
	   	        			nationalInsuranceBean.setDod(dod);
	   	        			nationalInsuranceBean.setUpdatedDate(new Date());
	   	        			objNationalInsuranceDaoImpl.updateDOD(nationalInsuranceBean);
	   	        		}
	   	        	}
	   	      }

        }
        catch(Exception e)
        {
        }
    }
}