/* This file is generated by TestGenerator, any edits will be overwritten by the next generation. */
package org.antlr.v4.test.runtime.legacy.swift;

import org.junit.Test;

@SuppressWarnings("unused")
public class TestSets extends BaseTest {

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testCharSetLiteral() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(78);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : (A {print($A.text)})+ ;\n");
		grammarBuilder.append("A : [AaBb] ;\n");
		grammarBuilder.append("WS : (' '|'\\n')+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="A a B b";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals(
			"A\n" +
			"a\n" +
			"B\n" +
			"b\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testComplementSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(51);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("parse : ~NEW_LINE;\n");
		grammarBuilder.append("NEW_LINE: '\\r'? '\\n';");
		String grammar = grammarBuilder.toString();


		String input ="a";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "parse", input, false);
		assertEquals("", found);

		assertEquals(
			"line 1:0 token recognition error at: 'a'\n" +
			"line 1:1 missing {} at '<EOF>'\n", this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testLexerOptionalSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(74);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : ('a'|'b')? 'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="ac";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("ac\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testLexerPlusSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(74);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : ('a'|'b')+ 'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="abaac";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("abaac\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testLexerStarSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(74);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : ('a'|'b')* 'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="abaac";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("abaac\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testNotChar() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(46);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print($A.text)} ;\n");
		grammarBuilder.append("A : ~'b' ;");
		String grammar = grammarBuilder.toString();


		String input ="x";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("x\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testNotCharSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(52);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print($A.text)} ;\n");
		grammarBuilder.append("A : ~('b'|'c') ;");
		String grammar = grammarBuilder.toString();


		String input ="x";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("x\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testNotCharSetWithLabel() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(54);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print($A.text)} ;\n");
		grammarBuilder.append("A : h=~('b'|'c') ;");
		String grammar = grammarBuilder.toString();


		String input ="x";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("x\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testNotCharSetWithRuleRef3() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(118);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print($A.text)} ;\n");
		grammarBuilder.append("A : ('a'|B) ;  // this doesn't collapse to set but works\n");
		grammarBuilder.append("fragment\n");
		grammarBuilder.append("B : ~('a'|'c') ;");
		String grammar = grammarBuilder.toString();


		String input ="x";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("x\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testOptionalLexerSingleElement() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(68);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : 'b'? 'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="bc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("bc\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testOptionalSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(66);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : ('a'|'b')? 'c' {print(try self._input.getText())} ;");
		String grammar = grammarBuilder.toString();


		String input ="ac";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("ac\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testOptionalSingleElement() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(68);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A? 'c' {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : 'b' ;");
		String grammar = grammarBuilder.toString();


		String input ="bc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("bc\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testParserNotSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(50);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : t=~('x'|'y') 'z' {print($t.text)} ;");
		String grammar = grammarBuilder.toString();


		String input ="zz";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("z\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testParserNotToken() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(60);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : ~'x' 'z' {print(try self._input.getText())} ;");
		String grammar = grammarBuilder.toString();


		String input ="zz";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("zz\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testParserNotTokenWithLabel() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(44);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : t=~'x' 'z' {print($t.text)} ;");
		String grammar = grammarBuilder.toString();


		String input ="zz";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("z\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testParserSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(45);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : t=('x'|'y') {print($t.text)} ;");
		String grammar = grammarBuilder.toString();


		String input ="x";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("x\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testPlusLexerSingleElement() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(68);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : 'b'+ 'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="bbbbc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("bbbbc\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testPlusSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(66);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : ('a'|'b')+ 'c' {print(try self._input.getText())} ;");
		String grammar = grammarBuilder.toString();


		String input ="abaac";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("abaac\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testRuleAsSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(73);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a @after {print(try self._input.getText())} : 'a' | 'b' |'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="b";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("b\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testSeqDoesNotBecomeSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(110);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : C {print(try self._input.getText())} ;\n");
		grammarBuilder.append("fragment A : '1' | '2';\n");
		grammarBuilder.append("fragment B : '3' '4';\n");
		grammarBuilder.append("C : A | B;");
		String grammar = grammarBuilder.toString();


		String input ="34";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("34\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testStarLexerSingleElement_1() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(68);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : 'b'* 'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="bbbbc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("bbbbc\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testStarLexerSingleElement_2() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(68);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : A {print(try self._input.getText())} ;\n");
		grammarBuilder.append("A : 'b'* 'c' ;");
		String grammar = grammarBuilder.toString();


		String input ="c";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("c\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	public void testStarSet() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(66);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("a : ('a'|'b')* 'c' {print(try self._input.getText())} ;");
		String grammar = grammarBuilder.toString();


		String input ="abaac";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "a", input, false);
		assertEquals("abaac\n", found);
		assertNull(this.stderrDuringParse);

	}


}
