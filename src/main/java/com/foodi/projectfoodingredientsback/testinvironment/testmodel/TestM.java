package com.foodi.projectfoodingredientsback.testinvironment.testmodel;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public class TestM {
        private List<Human> human;

        public TestM() {
        }

        public TestM(List<Human> humanList) {
                this.human = humanList;
        }

        public List<Human> getHumanList() {
                return human;
        }

        public void setHumanList(List<Human> humanList) {
                this.human = humanList;
        }


}

