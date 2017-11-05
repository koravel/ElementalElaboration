package kor.kortech.tileentity;

public class ProccessMachine extends TileKTWithSidedInventory
{
    public boolean isActive;
    protected int progress;
    //protected boolean isPowered;
    //protected boolean wasPowered;

    public ProccessMachine(int inventorySize, int inventoryStackLimit, int[] insertAssecibleSlots, int[] extractAssecibleSlots)
    {
        super(inventorySize, inventoryStackLimit, insertAssecibleSlots, extractAssecibleSlots);
    }

    @Override
    public void updateEntity()
    {
        if(isActive)
        {
            if(canProcess())
            {
                process();
            }
            else
            {
                if(canFinish())
                {
                    processFinish();

                    if(!canStart())
                    {
                        isActive = false;
                    }
                    else
                    {
                        processStart();
                    }
                }
            }
        }
        else
        {
            if(canStart())
            {
                processStart();
                isActive = true;
            }
        }
    }

    protected boolean canProcess()
    {
        return progress > 0 ? true : false;
    }

    protected void process()
    {
        progress--;
    }

    protected boolean canStart()
    {
        return false;
    }

    protected boolean canFinish()
    {
        return progress > 0 ? false : hasValidInput();
    }

    protected boolean hasValidInput()
    {
        return true;
    }

    protected void processStart()
    {

    }

    protected void processFinish()
    {

    }
}
