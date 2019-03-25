package effectivejava.CH2.javatuning.ch2.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {

    Map<String, IReportManager> financialReportManager = new HashMap<String, IReportManager>();
    Map<String, IReportManager> employeeReportManager = new HashMap<String, IReportManager>();

    //初始化一次即可，如果值变化，还得考虑更新
    IReportManager getFinancialReportManager(String tenantId) {
        IReportManager r = financialReportManager.get(tenantId);
        if (r == null) {
            r = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, r);
        }
        return r;
    }

    IReportManager getEmployeeReportReportManager(String tenantId) {
        IReportManager r = employeeReportManager.get(tenantId);
        if (r == null) {
            r = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, r);
        }
        return r;
    }
}
