package com.star.easydoc.view.inner;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.psi.PsiPackage;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageDescribeView extends DialogWrapper {
    private JPanel panel1;
    private JTable packageInfoTable;
    public PackageDescribeView(Map<PsiPackage, String> packMap) {
        super(false);

        this.packMap = packMap;
        createMap(packMap);

        init();
        setTitle("包信息生成");
    }
    private Map<PsiPackage, String> packMap;
    private Map<Integer, PsiPackage> packIndexMap;
    public Map<PsiPackage, String> getFinalMap(){
//        packageInfoTable.get
        TableCellEditor editor = packageInfoTable.getCellEditor();
        if (editor!=null){
            editor.stopCellEditing();
        }
        Map<PsiPackage, String> finalPackMap = new HashMap<>();
        for (Integer index : packIndexMap.keySet()) {
            PsiPackage psiPackage = packIndexMap.get(index);
            String value = (String)packageInfoTable.getValueAt(index, 1);
            finalPackMap.put(psiPackage,value);
        }
        return finalPackMap;
    }
    public void createMap(Map<PsiPackage, String> packMap){
        List<Map.Entry<PsiPackage, String>> list = new ArrayList<>(packMap.entrySet());
        String[][]  objs = new String[list.size()][2];
        packIndexMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            PsiPackage aPackage = list.get(i).getKey();
            objs[i][0]= aPackage.getQualifiedName();
            objs[i][1]=list.get(i).getValue();
            packIndexMap.put(i,aPackage);
        }
        DefaultTableModel innerModel = new DefaultTableModel(objs, new String[]{"包名称","注释"}){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==1){
                    return true;
                }else {
                    return false;
                }
            }
        };
        packageInfoTable.setModel(innerModel);
//        packageInfoTable.colum(0)
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return panel1;
    }
}
