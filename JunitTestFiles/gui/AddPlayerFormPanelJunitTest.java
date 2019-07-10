package gui;

import static org.junit.Assert.assertEquals;

import javax.swing.JComboBox;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddPlayerFormPanelJunitTest {
	
	AddPlayerFormPanel addPlayerFormPanel;
	
	@BeforeEach
	public void setUp() {
		addPlayerFormPanel = new AddPlayerFormPanel();
	}

	@Test
	public void IsPositionRelevantSkillsDisableEnable() {
		JComboBox positionJComboBox = addPlayerFormPanel.getPositionJComboBox();
		
		positionJComboBox.setSelectedIndex(1); //set to NOT goalkeeper
		boolean isGoalkeeperSkillSpinnerEnable_1 = addPlayerFormPanel.getHandlingGoalkeeperSpinner().isEnabled();
		boolean isGoalkeeperSkillSpinnerEnable_2 = addPlayerFormPanel.getDivingGoalkeeperSpinner().isEnabled();
		boolean isGoalkeeperSkillSpinnerEnable_3 = addPlayerFormPanel.getPositionGoalkeeperSpinner().isEnabled();
		boolean isGoalkeeperSkillSpinnerEnable_4 = addPlayerFormPanel.getReflexesGoalkeeperSpinner().isEnabled();
		boolean isGoalkeeperSkillSpinnerEnable_5 = addPlayerFormPanel.getKickingGoalkeeperSpinner().isEnabled();
		boolean isGoalkeeperSkillSpinnerEnable_6 = addPlayerFormPanel.getSpeedingGoalkeeperSpinner().isEnabled();
		
		boolean isRegularPlayerSkillSpinnerEnable_1 = addPlayerFormPanel.getDefenceRegularSpinner().isEnabled();
		boolean isRegularPlayerSkillSpinnerEnable_2 = addPlayerFormPanel.getPaceRegularSpinner().isEnabled();
		boolean isRegularPlayerSkillSpinnerEnable_3 = addPlayerFormPanel.getShootRegularSpinner().isEnabled();
		boolean isRegularPlayerSkillSpinnerEnable_4 = addPlayerFormPanel.getDribbleRegularSpinner().isEnabled();
		boolean isRegularPlayerSkillSpinnerEnable_5 = addPlayerFormPanel.getPassRegularSpinner().isEnabled();
		boolean isRegularPlayerSkillSpinnerEnable_6 = addPlayerFormPanel.getPowerRegularSpinner().isEnabled();
		
		boolean isGoalkeeperAllSkillEnable = isGoalkeeperSkillSpinnerEnable_1 && isGoalkeeperSkillSpinnerEnable_2
				&& isGoalkeeperSkillSpinnerEnable_3 && isGoalkeeperSkillSpinnerEnable_4 && isGoalkeeperSkillSpinnerEnable_5
				&& isGoalkeeperSkillSpinnerEnable_6;
		
		boolean isRegularPlayerAllSkillEnable = isRegularPlayerSkillSpinnerEnable_1 && isRegularPlayerSkillSpinnerEnable_2
				&& isRegularPlayerSkillSpinnerEnable_3 && isRegularPlayerSkillSpinnerEnable_4 && isRegularPlayerSkillSpinnerEnable_5
				&& isRegularPlayerSkillSpinnerEnable_6;
		
		//Regular Player skills enable - Goalkeeper Skill Disable
		assertEquals("Goalkeeper skills are disabled, Regular player skills Enabled", 
				isRegularPlayerAllSkillEnable, !isGoalkeeperAllSkillEnable); 
	}
		

}
