package entities;

import java.util.Comparator;


	public class CharacterComparator implements Comparator<Character>{ 
		private SortParameter[] parameters;
		
		public CharacterComparator(SortParameter[] parameters) {
			this.parameters = parameters;
		}
		
		public enum SortParameter{
			NAME_ASC,NAME_DES,AKA_ASC,AKA_DES,ISHERO_ASC,ISHERO_DES,
			AGL_ASC,AGL_DES,STR_ASC,STR_DES,CRT_ASC,CRT_DES,PHY_ASC,
			PHY_DES,DEF_ASC,DEF_DES,INT_ASC,INT_DES
		}
		@Override
		public int compare(Character ch1, Character ch2) {
			int comparison;
			int equalsCounter = 0;
			int b1;
			int b2;
			
			for(SortParameter parameter : parameters) {
				switch(parameter) {
				case AGL_DES:
					comparison = ch2.getAGL() - ch1.getAGL();
					if(comparison!=0)return comparison;
					break;
				case AGL_ASC:
					comparison = ch1.getAGL() - ch2.getAGL();
					if(comparison!=0)return comparison;
					break;
				case STR_DES:
					comparison = ch2.getSTR() - ch1.getSTR();
					if(comparison!=0)return comparison;
					break;
				case STR_ASC:
					comparison = ch1.getSTR() - ch2.getSTR();
					if(comparison!=0)return comparison;
					break;
				case CRT_DES:
					comparison = ch2.getCRT() - ch1.getCRT();
					if(comparison!=0)return comparison;
					break;
				case CRT_ASC:
					comparison = ch1.getCRT() - ch2.getCRT();
					if(comparison!=0)return comparison;
					break;
				case PHY_DES:
					comparison = ch2.getPHY() - ch1.getPHY();
					if(comparison!=0)return comparison;
					break;
				case PHY_ASC:
					comparison = ch1.getPHY() - ch2.getPHY();
					if(comparison!=0)return comparison;
					break;
				case DEF_DES:
					comparison = ch2.getDEF() - ch1.getDEF();
					if(comparison!=0)return comparison;
					break;
				case DEF_ASC:
					comparison = ch1.getDEF() - ch2.getDEF();
					if(comparison!=0)return comparison;
					break;
				case INT_DES:
					comparison = ch2.getINT() - ch1.getINT();
					if(comparison!=0)return comparison;
					break;
				case INT_ASC:
					comparison = ch1.getINT()  - ch2.getINT();
					if(comparison!=0)return comparison;
					break;
				case NAME_ASC:
					comparison = ch2.getRealName().compareTo(ch1.getRealName());
					if(comparison!=0) return comparison;
					equalsCounter++;
					break;
				case NAME_DES:
					comparison = ch1.getRealName().compareTo(ch2.getRealName());
					if(comparison!=0) return comparison;
					equalsCounter++;
					break;
				case AKA_ASC:
					comparison = ch2.getAka().compareTo(ch1.getAka());
					if(comparison != 0)return comparison;
					break;
				case AKA_DES:
					comparison = ch1.getAka().compareTo(ch2.getAka());
					if(comparison != 0)return comparison;
					break;
				case ISHERO_ASC:
					 b1 = ch1.getSide()? 1:0;
					b2 = ch2.getSide()? 1:0;
					comparison = b2-b1;
					if(comparison !=0)return comparison;
					equalsCounter++;
					break;
				case ISHERO_DES:
					 b1 = ch1.getSide()? 1:0;
					 b2 = ch2.getSide()? 1:0;
					comparison = b2-b1;
					if(comparison !=0)return comparison;
					equalsCounter++;
					break;
			
				}
			}	
			return ch1.getAka().compareTo(ch2.getAka());
		}
	}