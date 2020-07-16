package by.epam.committiee.command.impl;

public class MySpecialties implements ActionCommand{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();

        ServiceWarehouse serviceWarehouse = ServiceWarehouse.getInstance();
        SpecialtyService service = serviceWarehouse.getSpecialtyService();
        
                List<Specialty> specialties = service.findAll();
                request.setAttribute("specialties", specialities);
               
             
                page = PathPage.HOME;
            }catch (ServiceException e){
                page = PathPage.LOGIN;
            }
        } else {
            page = PathPage.LOGIN;
        }
        return page;
    }
}
