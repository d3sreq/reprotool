package reprotool.fm.nusmv.mapping

import com.google.inject.Inject
import java.util.HashMap
import reprotool.fm.nusmv.lang.nuSmvLang.Model
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory

class SampleSwprojBuilder {

	@Inject extension ReprotoolMappingExtensions
	@Inject private NuSmvLangFactory factory
	
	def Model createSampleModel() {
		
		val X1 = $(factory.createOtherModule) [
				name = "UC1"
				moduleElement += $(factory.createInitConstraint) [
					initExpr = "s=1"
				]
				moduleElement += $(factory.createAssignConstraint) [
					bodies += $(factory.createVarBodyAssign) [
						varId = "x"
						assignment = "ahoj"
					]
					bodies += $(factory.createNextBody) [
						varId = "s"
						nextExpr = "case s=1 : {2,3}; esac"
					]
				]
			]
			
		val X2 = $(factory.createOtherModule) [
				name = "UC2"
				moduleElement += $(factory.createVariableDeclaration)[
					vars += $(factory.createVarBody)[
						varId = "s"
						type = factory.createBooleanType
					]
					
				]
				moduleElement += $(factory.createInitConstraint) [
					initExpr = "s=1"
				]
			]
		
		return $(factory.createModel) [
			modules += $(factory.createMainModule)[
				name = "main"
				moduleElement += $(factory.createFairnessExpression)[
					fairnessExpr = "p=1"
				]
				moduleElement += $(factory.createFairnessExpression)[
					fairnessExpr = "p=2"
				]
				moduleElement += $(factory.createCtlSpecification) [
					ctlExpr = "AG( create_item -> AX(AG(!create_item)) )"
				]
				moduleElement += $(factory.createVariableDeclaration)[
					vars += $(factory.createVarBody)[
						varId = "x1"
						type = $(factory.createSyncrProcessType)[
							module = X1
						]
					]
					vars += $(factory.createVarBody)[
						varId = "x2"
						type = $(factory.createSyncrProcessType)[
							module = X2
						]
					]
				]
			]
			modules += X1
			modules += X2

			val x = new HashMap<String, String>()
			x += "key" -> "value"
		]
	}
}