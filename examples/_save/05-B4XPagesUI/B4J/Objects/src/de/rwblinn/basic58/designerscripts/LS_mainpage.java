package de.rwblinn.basic58.designerscripts;
import anywheresoftware.b4a.BA;


public class LS_mainpage{

public static void LS_800x700_1(anywheresoftware.b4a.BA ba, javafx.scene.Node parent, anywheresoftware.b4j.objects.LayoutValues lv,
anywheresoftware.b4j.objects.LayoutBuilder.LayoutData views, int width, int height, float scale)  throws Exception  {
;
//BA.debugLineNum = 6;BA.debugLine="DesignerToolbar.CreateToolbar( _ 	pnToolbar, _  	\"Toolbar\", _ 	\"F5 RUN\", \"RUN\", _ 	\"F6 LIST\", \"LIST\", _ 	\"F7 LOAD\", \"LOAD\", _   	\"F8 SAVE\", \"SAVE\", _  	\"F9 NEW\", \"NEW\", _  	\"F10 CLS\", \"CLS\")"[MainPage/800x700,scale=1]
anywheresoftware.b4j.objects.DesignerArgs.callsub(ba, parent, lv, "designertoolbar", "createtoolbar", width, height, views, new Object[] {"pntoolbar", "Toolbar", "F5 RUN", "RUN", "F6 LIST", "LIST", "F7 LOAD", "LOAD", "F8 SAVE", "SAVE", "F9 NEW", "NEW", "F10 CLS", "CLS"});
//BA.debugLineNum = 16;BA.debugLine="DDD.SpreadControlsHorizontally(pnToolbar, 120dip, 10dip)"[MainPage/800x700,scale=1]
anywheresoftware.b4j.objects.DesignerArgs.callsub(ba, parent, lv, "ddd", "spreadcontrolshorizontally", width, height, views, new Object[] {"pntoolbar", BA.NumberToString((120d * scale)), BA.NumberToString((10d * scale))});
//BA.debugLineNum = 18;BA.debugLine="DDD.CollectViewsData"[MainPage/800x700,scale=1]
anywheresoftware.b4j.objects.DesignerArgs.callsub(ba, parent, lv, "ddd", "collectviewsdata", width, height, views, new Object[] {});

}
}