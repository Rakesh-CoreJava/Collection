 package de.hybris.platform.customerreview.constants;
 import de.hybris.platform.core.Registry;
 import de.hybris.platform.core.Tenant;
 import de.hybris.platform.util.Config;
import de.hybris.platform.util.SingletonCreator.Creator;
import de.hybris.platform.util.config.ConfigIntf;
 import de.hybris.platform.util.config.ConfigIntf.ConfigChangeListener;
 import org.apache.log4j.Logger;
 public class CustomerReviewConstants extends GeneratedCustomerReviewConstants
{
   private static final Logger LOG = Logger.getLogger(CustomerReviewConstants.class.getName());
   private final ConfigIntf config;
  public volatile double MINRATING = 0.0D;
  public volatile double MAXRATING = 5.0D;
   private CustomerReviewConstants()
   {
     Tenant tenant = Registry.getCurrentTenantNoFallback();
    this.config = tenant.getConfig();
    this.MINRATING = getMinRating();
     this.MAXRATING = getMaxRating();
     this.config.registerConfigChangeListener(new ConfigIntf.ConfigChangeListener()
     {
       public void configChanged(String key, String value)
     {
       if (key.equals("customerreview.minimalrating"))
         {
           CustomerReviewConstants.this.MINRATING = CustomerReviewConstants.this.getMinRating();
         }
      else if (key.equals("customerreview.maximalrating"))
        {
         CustomerReviewConstants.this.MAXRATING = CustomerReviewConstants.this.getMaxRating();
        }
       }
     });
   }
 public static CustomerReviewConstants getInstance()
  {
    (CustomerReviewConstants)Registry.getSingleton(new SingletonCreator.Creator()
   {
     private final String SINGLETON_CREATOR_ID = CustomerReviewConstants.class.getName().intern();
    
    protected String getID()
     {
      return this.SINGLETON_CREATOR_ID;
     }
    
protected CustomerReviewConstants create()
  {
      return new CustomerReviewConstants(null);
       }
   });
}
 private double getMaxRating()
  {
 double maxRating = 0.0D;
     try
  {
     maxRating = this.config.getDouble("customerreview.maximalrating", 5.0D);
    }
  catch (NumberFormatException localNumberFormatException)
    {
      LOG.error("The parameter \"customerreview.maximalrating\" has illegal format (" + 
      Config.getParameter("customerreview.maximalrating") + "), using default value: " + 5.0D);
    }
     return maxRating;
   }
   private double getMinRating()
   {
     double minRating = 0.0D;
    try
   {
      minRating = this.config.getDouble("customerreview.minimalrating", 0.0D);
    }
   catch (NumberFormatException localNumberFormatException)
  {
       LOG.error("The parameter \"customerreview.minimalrating\" has illegal format (" + 
        Config.getParameter("customerreview.minimalrating") + "), using default value: " + 0.0D);
    }
     return minRating;
  }
 
   public static class DEFAULTS
   {
     public static final double MINIMAL_RATING = 0.0D;
   public static final double MAXIMAL_RATING = 5.0D;
   }
 
   public static class KEYS
   {
    public static final String MINIMAL_RATING = "customerreview.minimalrating";
 public static final String MAXIMAL_RATING = "customerreview.maximalrating";
}
}
